/*
 * GraphView
 * Copyright 2016 Jonas Gehring, 2021 Marco Cipriani
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.marcocipriani01.graphview.compat;

import android.annotation.TargetApi;
import android.os.Build;
import android.widget.OverScroller;

/**
 * A utility class for using {@link android.widget.OverScroller} in a backward-compatible fashion.
 */
@SuppressWarnings("unused")
public class OverScrollerCompat {
    /**
     * Disallow instantiation.
     */
    private OverScrollerCompat() {
    }
    /**
     * @see android.view.ScaleGestureDetector#getCurrentSpanY()
     */
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public static float getCurrVelocity(OverScroller overScroller) {
        return overScroller.getCurrVelocity();
    }
}