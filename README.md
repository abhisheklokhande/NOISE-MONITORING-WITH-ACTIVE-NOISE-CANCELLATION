# NOISE-MONITORING-WITH-ACTIVE-NOISE-CANCELLATION

## Overview
In this busy world, we are always surrounded by unwanted sound, often termed as noise, and this has become hazardous and is called as Noise Pollution. The tendency of human body to bear the noise is limited. The human body on long term exposure to noise can lead to various mental and physical health hazardous.
The idea for this problem, is providing an application to user, so that he can measure the noise around, and decide whether its hazardous for him or not. We even have a noise cancellation system, which uses noise cancelling algorithm to mitigate the noise so that the user is not affected by the noise around.

## Techologies Involved in the Project

#### Hardware
	1) Raspberry Pi3
	
#### Software
	1) IBM Watson IOT
	2) IBM Streaming Analysis
	3) Node Red
	4) GCC Compiler
	5) Android Studio
	
	
## Devices
	The main device for our project is the Raspberry Pi3 board, attached with headphones.

#### RASPBERRY PI
	The main task of RaspberryPi is to load the noise cancellation algorithm when the user is using the headphones. The RaspberryPi even sends out measured noise signal values to IBM Watson, which can help to record the history of noise recorded by the person using the headphones.
	The Pi board will always be needed to be connected to Internet so that the data can be transferred to IBM Watson for future computations.

#### HEADPHONES AND SPEAKERS.
	The headphones are connected using the usb extension of the Pi board and the Speakers are connected using the 3.5mm Audio Jack, prescribed for it. Hence, the audio is heard and calculated using the headphones and then the noise cancellation algorithm uses these noise signals and removes the unwanted noise from it, leaving a soothing audio which can be heard from the speakers.


#### NoiseMonitor Application
	The main part of our project, is the user-friendly mobile application which we have created. The main task of this application is to measure the noise using the mobile audio devices and our algorithm calculates the sound and converts it into decibel values. Using these Decibels Values, we can easily Identify the categories for noise to be beared and the level after which action needs to be taken.

	## Installation
	The application can be easily downloaded and installed. Adding the main advantage of user friendliness, the installation is easy and as soon as the app is installed. It can be opened and the noise can be monitored easily.
	
	##Run the Application
	The app can be run easily , without any login. Our app can be used by ANYONE, ANYTIME, ANYPLACE, to measure the noise around them.


### IBM Cloud Analysis:
This IBM Cloud analysis is usually the graph which keeps updating itself, as the amount of data it receives from the RaspberryPi board. This graph helps us understand the amount of noise which was measured around a human carrying this device along with headphones.




#### presentation links
https://www.slideshare.net/Abhiloki/noisestress-ppt2 <br/>
https://www.slideshare.net/Abhiloki/final-presentation-iot

#### HACSTER.IO
https://www.hackster.io/abhiloki333/noise-monitoring-and-active-noise-cancellation-de3af8


####Teams
1) Abhishek Lokhande
2) Mohammed Sukhsarwala
