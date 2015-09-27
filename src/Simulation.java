import java.util.ArrayList;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public abstract class Simulation {
	public List<String> myParameters;
	protected Cell[][] myGrid;
	protected ArrayList<Cell> myEmptyCells;
	double[] myDimensions;
	private boolean createChart = true;
	public static boolean showChart = false;
	private LineChart<Number, Number> chart;
	private ArrayList<String> possColors;
	private ArrayList<XYChart.Series<Number, Number>> series;
	int time = 0;

	public Simulation(double[] size, List<String> params) {
		myDimensions = size;
		myParameters = params;
	}
	
	public List<String> getParameters(){
		return myParameters;
	}
	public double[] getDimensions(){
		return myDimensions;
	}

	
	public void simStep (Cell[][] cells, String shape, BorderPane bd) {
		if (bd.getChildren().contains(chart));
		if (createChart) createChart(cells);
		Grid grid = new Grid();
		GUI myGUI = new GUI();
		String[][] newColors = new String[cells.length][cells[0].length];
		Cell[][] tempCell = new Cell[cells.length][cells[0].length];
		loopThroughCells(cells);
		for(int i=0; i < cells.length; i++) {
			for(int j=0; j< cells[i].length; j++) {
				newColors[i][j] = cells[i][j].getMyColor();
				tempCell[i][j] = cells[i][j];
			}
		}
		for (int i=0; i<cells.length; i++) {
			for (int j=0; j<cells[i].length; j++) {
			cells[i][j] = tempCell[i][j];
			Step.myCells[i][j] = cells[i][j];
			}
		}
	//	System.out.println(Step.myCells[0][0]);
		updateChart(cells);
		Pane pane = grid.makeGrid(newColors, shape);
		myGUI.addGrid(pane, bd);
		if (showChart) {
			myGUI.addChart(chart, bd);
		}
		time += 1;
	}
	
	public void createChart (Cell[][] cells) {
		chart = new LineChart<Number, Number>(new NumberAxis(), new NumberAxis());
		possColors = new ArrayList<String>();
		for (int i=0; i<cells.length; i++) {
			for (int j=0; j<cells.length; j++) {
				if (!possColors.contains(cells[i][j].myColor)) {
					possColors.add(cells[i][j].myColor);
				}
			}
		}
		chart.setTitle("Cell Frequencies");
		chart.getXAxis().setLabel("Time");
		chart.getYAxis().setLabel("Number of Cells");
		series = new ArrayList<XYChart.Series<Number, Number>>(); 
		for (int i=0; i<possColors.size(); i++) {
			series.add(new XYChart.Series<Number, Number>());
			series.get(i).setName(possColors.get(i));
			chart.getData().add(series.get(i));
			series.get(i).getNode().setStyle("-fx-stroke:" + possColors.get(i).toString()+";");
		}
		createChart = false;
	}
	
	public static void switchChart(){
		if (showChart){
			showChart = false;
		}
		else{
			showChart = true;
		}
	}
	
	public void updateChart(Cell[][] cells) {
		Integer[] freq = new Integer[possColors.size()];
		for (int i=0; i<freq.length; i++) {
			freq[i] = 0;
		}
		for (int i=0; i<cells.length; i++) {
			for (int j=0; j<cells.length; j++) {
				String cellColor = cells[i][j].myColor;
				if (possColors.contains(cellColor)) {
					freq[possColors.indexOf(cellColor)] = 
							freq[possColors.indexOf(cellColor)]+1;
				}
			}
		}
		for (int i=0; i<freq.length; i++) {
			chart.getData().get(i).getData().add(new XYChart.Data<Number, Number>(time, freq[i]));
		}
	}

	public abstract void loopThroughCells(Cell[][] cells);
}