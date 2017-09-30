package com.hyf.baseframe.ui.main;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.hyf.baseframe.R;
import com.hyf.baseframe.entitys.CookResult;
import com.hyf.baseframe.ui.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainContract.View {
    @Inject
    MainContract.Presenter presenter;
    @BindView(R.id.sasa)
    TextView sasa;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        presenter.getCookCategory();
    }

    @Override
    protected void initView() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void onError(int errCode) {
        Toast.makeText(this, errCode + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getCookCategory(CookResult cookResult) {
        Toast.makeText(this, cookResult.getChilds().size() + "", Toast.LENGTH_SHORT).show();
    }
}
