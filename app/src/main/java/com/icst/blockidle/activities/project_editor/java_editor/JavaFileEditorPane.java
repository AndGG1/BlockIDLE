/*
 *  This file is part of Block IDLE.
 *
 *  Block IDLE is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Block IDLE is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Block IDLE.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.icst.blockidle.activities.project_editor.java_editor;

import com.google.android.material.tabs.TabLayoutMediator;
import com.icst.blockidle.R;
import com.icst.blockidle.databinding.PaneJavaFileEditorBinding;
import com.icst.blockidle.util.IDLEJavaFile;
import com.icst.blockidle.view.PaneView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

public class JavaFileEditorPane extends LinearLayout implements PaneView {

	private Context context;
	private IDLEJavaFile javaFile;
	private PaneJavaFileEditorBinding binding;

	public JavaFileEditorPane(Context context, IDLEJavaFile javaFile) {
		super(context);
		this.context = context;
		this.javaFile = javaFile;

		LayoutInflater inflator = LayoutInflater.from(context);
		binding = PaneJavaFileEditorBinding.inflate(inflator);

		// Bind ViewPager and TabLayout
		TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
				binding.tab,
				binding.viewpager,
				(tab, position) -> {
					if (position == 0) {
						tab.setText("Variables");
					} else if (position == 1) {
						tab.setText("Events");
					}
				});
		tabLayoutMediator.attach();

		binding.getRoot()
				.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		addView(binding.getRoot());
	}

	@Override
	public Drawable getIcon() {
		return ContextCompat.getDrawable(getContext(), R.drawable.ic_java);
	}

	@Override
	public String getTitle() {
		return javaFile.getFileName();
	}

	@Override
	public View getView() {
		return this;
	}

	@Override
	public void onRelease() {
	}

	@Override
	public void onReleaseRequest() {
	}
}
