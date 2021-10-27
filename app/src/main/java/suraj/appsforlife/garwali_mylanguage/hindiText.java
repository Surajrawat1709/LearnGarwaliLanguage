package suraj.appsforlife.garwali_mylanguage;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class hindiText extends androidx.appcompat.widget.AppCompatTextView {
    public hindiText( Context context) {
        super(context);
        initTypeface(context);
    }

    public hindiText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTypeface(context);
    }

    public hindiText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTypeface(context);
    }
    private void initTypeface(Context context){
        Typeface typeface=Typeface.createFromAsset(context.getAssets(),"Devanagari.ttf");
        this.setTypeface(typeface);
    }
}

