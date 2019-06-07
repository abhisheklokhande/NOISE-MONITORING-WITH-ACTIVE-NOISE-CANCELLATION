# NOISE-MONITORING-WITH-ACTIVE-NOISE-CANCELLATION
#### project description using user scenario
this project is about noise cancellation using noise monitor application sending notifications to the Fitbit. if you are travelling home via metro but the vibrations and noise is too much. and you don't know how much decibels of sound it is providing. we can set some decibels on the application. if it reaches beyond that decibels it will remind you via Fitbit that power on the headphones to avoid the effect on your body. 

#### NOISE MONITOR ANDROID APPLICATION.
This is the android application which recognise the sound in decibels and gives you the analysis of the frequency. and through this application we connected our application to ibm waston iot. so with the help of ibm streaming analysis the noise captures with the frequencies.


#### RASPBERRY PI
Why we are considering raspberry pi is because we have to connect devices which is microphone and speaker.
To connect Raspberry pi with pc we struggle a lot without keyboard,mouse,monitor.
the easiest way to connect raspberry pi with pc is using keyboard,mouse,monitor.
after all the connection you can see the raspbian operating system on the monitor it will install all the files and after that you can connect it to the wifi using your mobile hotspot. and after that you can remove the connections and you can see the IP address in the ipscanner software. copy the IP address and paste it on putty so that you can get access to the command prompt of raspberry pi.
after that you have to insert the user id and password. user : pi ; password : raspberry. you can insert the c code using vm and you can run the program.
it this code we have taken the random data to get the output.    <BR/>
for (int i = 0; i < M; i++) <BR/>
      Y += (W[i] * X[i]);		//calculate filter output <BR/>
E = D - Y;		//calculate error signal <BR/>
for (int i = 0; i < M ; i++) <BR/>
	W[i] = W[i] + (mu * E * X[i]);		//update filter coefficients <BR/>
for (int i = 0; i < I; i++) <BR/>
		Input[i] = rand() / (float)RAND_MAX; <BR/>
	for (int i = 0; i < I; i++) <BR/>
		for (int j = 0; j < M; j++) <BR/>
			if (i - j >= 0) <BR/>
				Desired[i] += Input[i - j] * H[j]; <BR/>
#### ANC HEADPHONES. 
IN THIS PROJECT WE DONT USE THE ANC HEADPHONES. INSTEAD OF THAT WE ARE USING RASPBERRY PI WITH MICROPHONE AND SPEAKER.
SO IN THIS RASPBERRY PI WE ARE INSERTING THE CODE OF LMS ALGORITHM AND ADAPTIVE FILTERS SO THAT THE RASPBERRY PI RECOGNISE 
THE SOUND FROM MICROPHONE AND THROUGH THE LMS ALGORITHM AND ADAPTIVE FILTERS IT WILL CANCEL THE NOISE.
#### NODE-RED
You have to select the design in the node red which is already installed in the ibm Watson iot. you have to select the execution call() and some javascript functions to connect the raspberry pi to the ibm Watson iot. after the design you just select the deploy button on the right side of the node-red software.

#### CLOUD PART
After the deployment you can see the analysis and frequency of the random data which we have given in the code in the ibm streaming analysis. After that using node-red you can send the notification to the mobile app or Fitbit using some protocols and fuctions. 


### IBM Cloud Analysis Link:
https://quickstart.internetofthings.ibmcloud.com/#/device/cacd5757.bcd0a8/sensor/


#### presentation links
https://www.slideshare.net/Abhiloki/noisestress-ppt2 <br/>
https://www.slideshare.net/Abhiloki/final-presentation-iot

#### HACSTER.IO
https://www.hackster.io/abhiloki333/noise-monitoring-and-active-noise-cancellation-de3af8
