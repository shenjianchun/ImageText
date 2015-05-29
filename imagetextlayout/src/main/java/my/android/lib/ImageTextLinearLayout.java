package my.android.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * ImageView和TextView水平整合的Layout
 * 里面加了BadgeView，可以在ImageView上面显示数字或者其他的文本
 * Created by 14110105 on 2015/5/29.
 */
public class ImageTextLinearLayout extends LinearLayout {

    ImageView mImageView;
    TextView mTextView;
    BadgeView badge;

    public ImageTextLinearLayout(Context context) {
        this(context, null);
    }

    public ImageTextLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImageTextLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context
                .LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.image_text_layout, this, true);
        mImageView = (ImageView) findViewById(R.id.image);
        mTextView = (TextView) findViewById(R.id.text);
        /*初始化BadgeView*/
        badge = new BadgeView(context, mImageView);
        /*去掉Margin*/
        badge.setBadgeMargin(0);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ImageTextLinearLayout,
                defStyleAttr, 0);

        Drawable d = a.getDrawable(R.styleable.ImageTextLinearLayout_imageSrc);
        if (d != null) {
            setImage(d);
        }

        CharSequence text = a.getText(R.styleable.ImageTextLinearLayout_text);
        if(text != null) {
            setText(text);
        }

        a.recycle();
    }

    public void setImage(Drawable drawable) {
        mImageView.setImageDrawable(drawable);
    }

    public void setText(CharSequence text) {
        mTextView.setText(text);
    }


    public ImageView getImageView() {
        return mImageView;
    }

    public TextView getTextView() {
        return mTextView;
    }


    public void showBadgeView(String content) {
        badge.setText(content);
        badge.show();
    }

    public void dismissBadgeView() {
        badge.hide();
    }

}
