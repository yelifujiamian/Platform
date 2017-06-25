package org.ninetripods.mq.study.bezier.view.BeaierDemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import org.ninetripods.mq.study.BaseActivity;
import org.ninetripods.mq.study.R;

public class BezierTwoActivity extends BaseActivity {
    private Toolbar toolbar;

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_bezier_two);
    }

    @Override
    public void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        initToolBar(toolbar, "二阶贝塞尔曲线", true);
    }

    @Override
    public void initEvents() {
        super.initEvents();
    }
}
