# HintSpinner

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)
[![jitPack](https://jitpack.io/v/jaiselrahman/HintSpinner.svg)](https://jitpack.io/#jaiselrahman/HintSpinner)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-HintSpinner-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/7546)

Spinner widget with Hint/Header label.

## Installation

Step 1: Add it in your root build.gradle at the end of repositories

```gradle
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
```

Step 2: Add the dependency

```gradle
    dependencies {
        ...
        implementation 'com.github.jaiselrahman:HintSpinner:1.0.0'
    }
```

## Usage

In xml layout,

```xml
    <com.jaiselrahman.hintspinner.HintSpinner
            android:id="@+id/hint_spinner"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />
```

In Java,

```java
    HintSpinner hintSpinner = findViewById(R.id.hint_spinner);
    hintSpinner.setAdapter(new HintSpinnerAdapter<String>(this, strings, "Your Hint"));
```

If you are using custom objects then your can override ```getLabelFor(T t)``` to get label.

```java
    hintSpinner.setAdapter(new HintSpinnerAdapter<Person>(this, persons, "Select a person") {
        @Override
        public String getLabelFor(Person person) {
            return person.getName();
        }
    });
```

You can also change the hint dynamically.

```java
    hintSpinnerAdapter.setHint("Your Hint");
    hintSpinnerAdapter.notifyDataSetChanged();
```

## License

    Copyright 2018, JaiselRahman

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
