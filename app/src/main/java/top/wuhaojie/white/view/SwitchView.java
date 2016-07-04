package top.wuhaojie.white.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import top.wuhaojie.white.R;

/**
 * Created by wuhaojie on 2016/7/4 11:52.
 */
public class SwitchView extends LinearLayout {

    public static final int MAX_LEVEL = 3;
    private Context mContext;

    private ImageView mImageView0;
    private ImageView mImageView1;
    private ImageView mImageView2;
    private int mCurrLevel;

    public SwitchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.switch_view, this, true);
        mImageView0 = (ImageView) view.findViewById(R.id.iv_0);
        mImageView1 = (ImageView) view.findViewById(R.id.iv_1);
        mImageView2 = (ImageView) view.findViewById(R.id.iv_2);
        setLevel(MAX_LEVEL);
    }

    public SwitchView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwitchView(Context context) {
        this(context, null);
    }

    public void setLevel(int level) {
        if (level < 0 || level > MAX_LEVEL) throw new IllegalArgumentException("等级不能小于零");
        switch (level) {
            case 0:
                setImageViewVisibility(INVISIBLE, INVISIBLE, INVISIBLE);
                break;
            case 1:
                setImageViewVisibility(VISIBLE, INVISIBLE, INVISIBLE);
                break;
            case 2:
                setImageViewVisibility(VISIBLE, VISIBLE, INVISIBLE);
                break;
            case 3:
                setImageViewVisibility(VISIBLE, VISIBLE, VISIBLE);
                break;
        }
        mCurrLevel = level;
    }


    public int addLevel() {
        setLevel(mCurrLevel = (mCurrLevel + 1) % (MAX_LEVEL + 1));
        return mCurrLevel;
    }

    public int subLevel() {
        setLevel(mCurrLevel = (mCurrLevel - 1) % (MAX_LEVEL + 1));
        return mCurrLevel;
    }

    private void setImageViewVisibility(int... v) {
        mImageView0.setVisibility(v[0]);
        mImageView1.setVisibility(v[1]);
        mImageView2.setVisibility(v[2]);
    }

}
