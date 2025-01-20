/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fp.data;


import android.os.Build
import androidx.annotation.RequiresApi
import com.fp.R
import com.fp.model.Artist;
import java.time.LocalDate
import java.time.format.DateTimeFormatter


/**
 * [Datasource] generates a list of [Affirmation]
 */
class Datasource() {
    @RequiresApi(Build.VERSION_CODES.O)
    fun loadArtist(): List<Artist> {
        return listOf<Artist>(
            Artist(
                R.string.aretha_franklin_summary,
                R.drawable.aretha_franklin,
                "Aretha Franklin",
                LocalDate.parse("1942-03-25"),
                3000.0
            ),
            Artist(
                R.string.whitney_houston_summary,
                R.drawable.whitney_houston,
                "Whitney Houston",
                LocalDate.parse("1963-08-09"),
                4000.0
            ),
            Artist(
                R.string.sam_cooke_summary,
                R.drawable.sam_cooke,
                "Sam Cooke",
                LocalDate.parse("1931-01-22"),
                4000.0
            ),
            Artist(
                R.string.billie_holiday_summary,
                R.drawable.billie_holiday,
                "Billie Holiday",
                LocalDate.parse("1915-04-07"),
                1000.0
            ),
            Artist(
                R.string.mariah_carey_summary,
                R.drawable.mariah_carey,
                "Mariah Carey",
                LocalDate.parse("1969-03-27"),
                2000.0
            ),
            Artist(
                R.string.ray_charles_summary,
                R.drawable.ray_charles,
                "Ray Charles Houston",
                LocalDate.parse("1930-09-23"),
                3000.0
            ),
            Artist(
                R.string.stevie_wonder,
                R.drawable.stevie_wonder,
                "Stevie Wonder",
                LocalDate.parse("1950-05-13"),
                2500.75
            ),
            Artist(
                R.string.beyonce_summary,
                R.drawable.beyonce,
                "Beyonce",
                LocalDate.parse("1981-09-04"),
                5000.00
            ),
            Artist(
                R.string.otis_reading_summary,
                R.drawable.otis_redding,
                "Otis Redding",
                LocalDate.parse("1941-09-09"),
                1050.00
            ),
            Artist(
                R.string.al_green_summary,
                R.drawable.al_green,
                "Al Green",
                LocalDate.parse("1946-04-13"),
                750.00
            )
        )
    }
}
