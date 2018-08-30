package com.kyrie.drawlots;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Tao
 * Date: 2018/8/30
 */

public class PlayerAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public PlayerAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_name, (helper.getLayoutPosition() + 1) + ". " + item);
    }
}
