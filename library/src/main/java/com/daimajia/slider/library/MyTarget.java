package com.daimajia.slider.library;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ViewTarget;

/**
 * Created by amir on 4/2/16.
 */
public class MyTarget<Z> extends ViewTarget<ImageView, Z> implements GlideAnimation.ViewAdapter {

	public MyTarget(ImageView view) {
		super(view);
	}

	/**
	 * Returns the current {@link android.graphics.drawable.Drawable} being displayed in the view using
	 * {@link android.widget.ImageView#getDrawable()}.
	 */
	@Override
	public Drawable getCurrentDrawable() {
		return view.getDrawable();
	}

	/**
	 * Sets the given {@link android.graphics.drawable.Drawable} on the view using
	 * {@link android.widget.ImageView#setImageDrawable(android.graphics.drawable.Drawable)}.
	 *
	 * @param drawable {@inheritDoc}
	 */
	@Override
	public void setDrawable(Drawable drawable) {
		view.setImageDrawable(drawable);
	}

	/**
	 * Sets the given {@link android.graphics.drawable.Drawable} on the view using
	 * {@link android.widget.ImageView#setImageDrawable(android.graphics.drawable.Drawable)}.
	 *
	 * @param placeholder {@inheritDoc}
	 */
	@Override
	public void onLoadStarted(Drawable placeholder) {
		view.setImageDrawable(placeholder);
	}

	/**
	 * Sets the given {@link android.graphics.drawable.Drawable} on the view using
	 * {@link android.widget.ImageView#setImageDrawable(android.graphics.drawable.Drawable)}.
	 *
	 * @param errorDrawable {@inheritDoc}
	 */
	@Override
	public void onLoadFailed(Exception e, Drawable errorDrawable) {
		view.setImageDrawable(errorDrawable);
	}

	/**
	 * Sets the given {@link android.graphics.drawable.Drawable} on the view using
	 * {@link android.widget.ImageView#setImageDrawable(android.graphics.drawable.Drawable)}.
	 *
	 * @param placeholder {@inheritDoc}
	 */
	@Override
	public void onLoadCleared(Drawable placeholder) {
		view.setImageDrawable(placeholder);
	}

	@Override
	public void onResourceReady(Z resource, GlideAnimation<? super Z> glideAnimation) {
		if (glideAnimation == null || !glideAnimation.animate(resource, this)) {
			setResource(resource);
		}
	}

	public void setResource(Z resource) {
		view.setImageDrawable((GlideBitmapDrawable) resource);

	}


}
