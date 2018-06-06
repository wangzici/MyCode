package wzt.myedittext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/**
 * @author Tao
 * @date 2018/6/6
 * desc:
 */
@SuppressLint("AppCompatCustomView")
public class MyEditText extends EditText {
    private static final String TAG = "MyEditText";

    public MyEditText(Context context) {
        this(context, null);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        initEvent();
    }

    private void initView() {
        setGravity(Gravity.CENTER);
    }

    private void initEvent() {
        setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.i(TAG, "[onFocusChange]hasFocus = " + hasFocus);
                if (hasFocus) {
                    setGravity(Gravity.LEFT);
                } else if (getEditableText().length() == 0 && !hasFocus) {
                    setGravity(Gravity.CENTER_HORIZONTAL);
                }
            }
        });

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Log.i(TAG, "[onTouch]hasFocus = " + hasFocus());
                    if (!hasFocus()) {
                        /*setFocusable(true);
                        setFocusableInTouchMode(true);
                        requestFocus();
                        requestFocusFromTouch();*/
                    }
                }
                return false;
            }
        });

        /*addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i(TAG, "[beforeTextChanged]");
                setGravity(Gravity.START);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i(TAG, "[beforeTextChanged]s.length() = " + s.length());
                if (s.length() == 0) {
                    setGravity(Gravity.CENTER);
                }
            }
        });*/
    }
}
