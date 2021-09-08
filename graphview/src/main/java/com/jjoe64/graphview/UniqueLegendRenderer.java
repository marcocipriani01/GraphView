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
package com.jjoe64.graphview;

import android.util.Pair;

import com.jjoe64.graphview.series.Series;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A LegendRenderer that renders items with the same name and color only once in the legend
 * Created by poseidon on 27.02.18.
 */
public class UniqueLegendRenderer extends LegendRenderer {
    /**
     * creates legend renderer
     *
     * @param graphView regarding graphview
     */
    public UniqueLegendRenderer(GraphView graphView) {
        super(graphView);
    }

    @Override
    protected List<Series<?>> getAllSeries() {
        List<Series<?>> originalSeries = super.getAllSeries();
        List<Series<?>> distinctSeries = new ArrayList<>();
        Set<Pair<Integer,String>> uniqueSeriesKeys = new HashSet<>();
        for(Series<?> series : originalSeries)
            if(uniqueSeriesKeys.add(new Pair<>(series.getColor(), series.getTitle())))
                distinctSeries.add(series);
        return distinctSeries;
    }
}