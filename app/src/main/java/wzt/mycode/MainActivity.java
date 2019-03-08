package wzt.mycode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Paint paint = new Paint();
        // dst_in 模式，实现底层透明度随上层透明度进行同步显示（即上层为透明时，下层就透明，并不是上层覆盖下层)
        final Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        Bitmap test = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        RadialGradient radialGradient = new RadialGradient(100, 100, 100, Color.BLACK, Color.TRANSPARENT, Shader.TileMode.CLAMP);
//        LinearGradient linearGradient = new LinearGradient(0, 0, 0, 200, new int[]{Color.TRANSPARENT, Color.BLACK, Color.BLACK, Color.TRANSPARENT}, new float[]{0f, 0.4f, 0.6f, 1f}, Shader.TileMode.CLAMP);
        LinearGradient linearGradient2 = new LinearGradient(0, 0, 200, 0, new int[]{Color.TRANSPARENT, Color.BLACK, Color.BLACK, Color.TRANSPARENT}, new float[]{0f, 0.4f, 0.6f, 1f}, Shader.TileMode.CLAMP);
        ComposeShader composeShader = new ComposeShader(linearGradient2, radialGradient, PorterDuff.Mode.DST_IN);
        Bitmap result = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
        Matrix matrix = new Matrix();
        float scaleX = 200f / (float) test.getWidth();
        float scaleY = 200f / (float) test.getHeight();
        matrix.setScale(scaleX, scaleY);
        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(test, matrix, paint);
        paint.setXfermode(xfermode);
        paint.setShader(composeShader);
        canvas.drawRect(0, 0, 200, 200, paint);
        paint.setXfermode(null);
//        imageView.setImageBitmap(result);


/*        if (source == null) return null;
        Bitmap result = pool.get(outWidth, outHeight, Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(outWidth, outHeight, Bitmap.Config.ARGB_8888);
        }
        Matrix matrix = new Matrix();
        matrix.setScale((float) outWidth / (float) source.getWidth(), (float) outHeight / (float) source.getHeight());
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        //1.先画圆角矩形的图片
        BitmapShader bitmapShader = new BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawRoundRect(new RectF(0, 0, outWidth, outHeight), 20, 20, paint);

        //2.再通过DST_IN画渐变透明效果(用两个LinearGradient是由于最右侧不够全透明，仍然会有边框显示，所以叠加一个用于实现更透明的效果)
        LinearGradient linearGradient = new LinearGradient(0, 0, outWidth, 0,
                new int[]{Color.BLACK, Color.TRANSPARENT, Color.TRANSPARENT}, new float[]{0f, 0.8f, 1f}, Shader.TileMode.CLAMP);
        LinearGradient linearGradient2 = new LinearGradient(outWidth * 3 / 4, 0, outWidth, 0,
                Color.BLACK, Color.TRANSPARENT, Shader.TileMode.CLAMP);
        ComposeShader composeShader = new ComposeShader(linearGradient, linearGradient2, PorterDuff.Mode.DST_IN);
        paint.setShader(composeShader);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawRect(0, 0, outWidth, outHeight, paint);
        return result;*/
    }
}
