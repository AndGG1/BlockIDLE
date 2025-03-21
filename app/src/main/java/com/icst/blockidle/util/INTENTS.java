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

package com.icst.blockidle.util;

import android.app.Activity;
import android.content.Intent;

public class INTENTS {
	public static void changeScreen(Activity activity, Class<?> c) {
		Intent intent = new Intent(activity, c);
		activity.startActivity(intent);
		activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
	}

}
