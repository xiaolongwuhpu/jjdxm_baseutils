package com.dou361.third_feedback;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;

import com.jingwang.eluxue_online.R;
import com.umeng.fb.fragment.FeedbackFragment;

/**
 * Demo Activity to use {@link FeedbackFragment}
 */
public class ConversationDetailActivity extends FragmentActivity {

    private FeedbackFragment mFeedbackFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cd);

        if (savedInstanceState == null) {
            String conversation_id = getIntent().getStringExtra(FeedbackFragment.BUNDLE_KEY_CONVERSATION_ID);
            mFeedbackFragment = FeedbackFragment.newInstance(conversation_id);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, mFeedbackFragment)
                    .commit();
        }
    }

    @Override
    protected void onNewIntent(android.content.Intent intent) {
        mFeedbackFragment.refresh();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}