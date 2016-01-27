package com.example.admin.friend;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by admin on 27-01-2016.
 */
public class RoundImage extends Drawable {
    private final Bitmap mbitmap;
    private final Paint paint;
    private final RectF rectF;
    private final int bitmapwidth;
    private final int bitmapheight;
    public RoundImage(Bitmap bitmap){
        mbitmap=bitmap;
        paint=new Paint();
        rectF=new RectF();
        paint.setAntiAlias(true);
        paint.setDither(true);
        final BitmapShader shader=new BitmapShader(bitmap,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
        paint.setShader(shader);
        bitmapwidth=mbitmap.getWidth();
        bitmapheight=mbitmap.getHeight();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawOval(rectF,paint);
    }

    @Override
    public void setAlpha(int alpha) {
if (paint.getAlpha()!=alpha){
    paint.setAlpha(alpha);
    invalidateSelf();
}
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public void setFilterBitmap(boolean filter) {
        paint.setFilterBitmap(filter);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        rectF.set(bounds);
    }

    public Bitmap getBitmap(){
        return mbitmap;
    }
}
