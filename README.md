"# CalculatorDialog"

<img src="https://raw.githubusercontent.com/Far5had70/CalculatorDialog/master/record.gif" height="480" width="270">

 CalculatorDialog is a beautiful calculator dialog for Android.

# Installation

Step 1. Add the JitPack repository to your build file


Add it in your root build.gradle at the end of repositories:

```gradle
	dependencies {
	        implementation 'com.github.Far5had70:CalculatorDialog:1.0.0'
	}
```


Step 2. Add the dependency
```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```




## Demo

You can try it out here [Sample Application](https://github.com/Far5had70/CalculatorDialog/blob/master/app/src/main/java/com/sharjbook/calculator/MainActivity.java)




# Usage



**Example:**

```java

                CalculatorDialog calculatorDialog = new CalculatorDialog()
                        .setAlertRadius(30)
                        .setCalc("0")
                        .setTypeFace(Typeface.createFromAsset(getAssets(), "bsans.ttf"))
                        .setListener(new Listener() {
                            @Override
                            public void OnSelectListener(int result) {
                                Toast.makeText(MainActivity.this, ""+result, Toast.LENGTH_SHORT).show();
                            }
                        });
                calculatorDialog.show(getSupportFragmentManager() , "");

```


# Developed By

Farshad Asgharzadeh

For contact, shoot me an email at ferik800@gmail.com

