#define mu 0.2f				//convergence rate
#define M 5					//order of filter
#define I 1000				//number of samples

double Input[I] = { 0.0 };
double Desired[I] = { 0.0 };

//double H[M] = { 1, 0.5, 0.25, 0.125, 0.0625 };	//the main system
double H[M] = { 0.0625, 0.125, 0.25, 0.5, 1 };		//we need inverse of main system to convolution


void initialize()
{
	for (int i = 0; i < I; i++)
		Input[i] = rand() / (float)RAND_MAX;

	for (int i = 0; i < I; i++)
	for (int j = 0; j < M; j++)
	if (i - j >= 0)
		Desired[i] += Input[i - j] * H[j];
}

void main()
{
	initialize();

	long T, n = 0;
	double D, Y, E;
	double W[M] = { 0.0 };
	double X[M] = { 0.0 };

	FILE	*Y_out, *error, *weights;

	Y_out = fopen("Y_OUT", "w++");				//file for output samples
	error = fopen("ERROR", "w++");				//file for error samples
	weights = fopen("WEIGHTS", "w++");			//file for weights samples


	for (T = 0; T < I; T++)
	{
			for (int m = T; m > T - M; m--){
				if (m >= 0)
					X[M + (m - T) - 1] = Input[m];	//X new input sample for 
									//LMS filter
				else break;
			}

			D = Desired[T];					//desired signal
			Y = 0;						//filter’output set to zero

			for (int i = 0; i < M; i++)
				Y += (W[i] * X[i]);			//calculate filter output

			E = D - Y;					//calculate error signal

			for (int i = 0; i < M; i++)
				W[i] = W[i] + (mu * E * X[i]);		//update filter coefficients

			fprintf(Y_out, "\n % 10g % 10f", (float)T, Y);
			fprintf(error, "\n % 10g % 10f", (float)T, E);
	}

	for (int i = 0; i < M; i++)
		fprintf(weights, "\n % 10d % 10f", i, W[i]);

	fclose(Y_out);
	fclose(error);
	fclose(weights);
}
