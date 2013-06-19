package kr.pe.hl1vxg.pic;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SolveTextView extends TextView implements OnClickListener {
	private String answer;

	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public SolveTextView(Context context) {
		super(context);
		this.setOnClickListener(this);
		this.setTextAppearance(getContext(), R.style.SolveText_normal);
	}
	
	public boolean isCorrect() {
		if ( this.getAnswer().equals(this.getText())) {
			this.setTextAppearance(getContext(), R.style.SolveText_correct);
			this.setBackgroundResource(R.color.correctBackgroundColor);
			return true;
		} else {
			this.setTextAppearance(getContext(), R.style.SolveText_incorrect);
			this.setBackgroundResource(R.color.inCorrectBackgroundColor);
			return false;
		}
	}
	
	// TODO addTextChangedListener


	@Override
	public void onClick(View v) {
		this.setText("");
		this.setBackgroundResource(R.color.solveBackgroundColor);
	}
}
