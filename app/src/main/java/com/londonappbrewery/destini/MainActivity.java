package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryView;
    private Button mAnswer1Button;
    private Button mAnswer2Button;
    private Button mResetButton;
    private int mIndex;
    private int mStory;
    private int mAnswer1;
    private int mAnswer2;
    private int mStoryIndex = 1;
    private StoryLine[] mStoryWay = new StoryLine[]{
            new StoryLine (R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
            new StoryLine(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new StoryLine(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2)
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryView = (TextView) findViewById(R.id.storyTextView);
        mAnswer1Button = (Button) findViewById(R.id.buttonTop);
        mAnswer2Button = (Button) findViewById(R.id.buttonBottom);
        mResetButton = (Button) findViewById(R.id.buttonReset);
        mResetButton.setVisibility(View.GONE);

        mStory = mStoryWay[mIndex].getStoryID();
        mStoryView.setText(mStory);
        mAnswer1 = mStoryWay[mIndex].getAnswer1ID();
        mAnswer2 = mStoryWay[mIndex].getAnswer2ID();
        mAnswer1Button.setText(mAnswer1);
        mAnswer2Button.setText(mAnswer2);




        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mAnswer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStoryIndex == 1 && mIndex == 0) {
                    mIndex += 2;
                    updateStory();
                    mStoryIndex += 1;
                } else if (mStoryIndex == 2 && mIndex == 2) {
                    mStoryView.setText(R.string.T6_End);
                    mAnswer1Button.setVisibility(View.GONE);
                    mAnswer2Button.setVisibility(View.GONE);
                    mResetButton.setVisibility(View.VISIBLE);
                } else if (mStoryIndex == 2 && mIndex == 1) {
                    mIndex += 1;
                    updateStory();
                } else {
                    mStoryView.setText(R.string.T6_End);
                    mAnswer1Button.setVisibility(View.GONE);
                    mAnswer2Button.setVisibility(View.GONE);
                    mResetButton.setVisibility(View.VISIBLE);
                }

            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mAnswer2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mIndex == 0 && mStoryIndex == 1) {
                    mIndex += 1;
                    updateStory();
                    mStoryIndex +=1;
                } else if (mIndex == 2 && mStoryIndex == 2) {
                    mStoryView.setText(R.string.T5_End);
                    mAnswer1Button.setVisibility(View.GONE);
                    mAnswer2Button.setVisibility(View.GONE);
                    mResetButton.setVisibility(View.VISIBLE);
                } else if (mIndex == 1 && mStoryIndex == 2) {
                    mStoryView.setText(R.string.T4_End);
                    mAnswer1Button.setVisibility(View.GONE);
                    mAnswer2Button.setVisibility(View.GONE);
                    mResetButton.setVisibility(View.VISIBLE);
                } else {
                    mStoryView.setText(R.string.T5_End);
                    mAnswer1Button.setVisibility(View.GONE);
                    mAnswer2Button.setVisibility(View.GONE);
                    mResetButton.setVisibility(View.VISIBLE);
                }
            }
        });

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIndex = 0;
                mStoryIndex = 1;
                updateStory();
                mAnswer1Button.setVisibility(View.VISIBLE);
                mAnswer2Button.setVisibility(View.VISIBLE);
            }
        });


    }

    public void updateStory() {
        mStory = mStoryWay[mIndex].getStoryID();
        mStoryView.setText(mStory);
        mAnswer1 = mStoryWay[mIndex].getAnswer1ID();
        mAnswer2 = mStoryWay[mIndex].getAnswer2ID();
        mAnswer1Button.setText(mAnswer1);
        mAnswer2Button.setText(mAnswer2);
        mResetButton.setVisibility(View.GONE);
    }


}