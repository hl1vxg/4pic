package kr.pe.hl1vxg.pic;

import kr.pe.hl1vxg.pic.db.DBAdapterTest;
import kr.pe.hl1vxg.pic.db.Problem;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity {
//	static DBAdapter dbAdapter;
	static DBAdapterTest dbAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		dbAdapter = new DBAdapter(this);
		dbAdapter = new DBAdapterTest(this);
		this.selectProblem();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/**
	 * Select problem.
	 */
	private void selectProblem() {
		
		Problem problem = this.dbAdapter.getProblem(1);
		
		// make hint area
		TableLayout hintArea = (TableLayout)findViewById(R.id.HintArea);
		TableRow hintRow1 = new TableRow(this);
		TableRow hintRow2 = new TableRow(this);
		hintArea.addView(hintRow1);
		hintArea.addView(hintRow2);
		// set hint
		String[] hint = problem.getHintArray();
		
		for (int i = 0; i < hint.length; i++) {
			Button btn = new Button(this);
			new HintAlphabet(btn, hint[i]);
			
			if ( i < 5) {
				hintRow1.addView(btn);
			} else {
				hintRow2.addView(btn);
			}
		}
		
		// make solve area 
		TableRow solveArea = (TableRow)findViewById(R.id.SolveArea);
		
		String[] solve = problem.getSolveArray();
		
		for (int i = 0; i < solve.length; i++) {
			TextView solveText = new TextView(this);
			
//			solveText.setText(solve[i]);
			solveArea.addView(solveText);
		}
		
	}
	
	class HintAlphabet implements OnClickListener {
		String s;
		
		public HintAlphabet(Button btn , String s) {
			this.s = s;
			btn.setText(s);
			btn.setOnClickListener(this);
		}
		
		public void onClick(View v) {
			TableRow solveArea = (TableRow)findViewById(R.id.SolveArea);
			int cnt = solveArea.getChildCount();
			for ( int i = 0 ; i < cnt; i++) {
				TextView solve = (TextView)solveArea.getChildAt(i);
				if ("".equals(solve.getText())){
					solve.setText(this.s);
					return;
				}
			}
			
			
		}
		
	}
	
	


}
