import pandas as pd
from sklearn import datasets, linear_model, metrics
import numpy as np
import seaborn
import matplotlib.pyplot as plt
data = pd.read_csv('sifirsizPcaData.csv')

#, usecols=['DC','DMC','AREA']
'''
dizi = []
for i in range(len(data)):
    dizi.append(1)

data.insert(loc=0, column='bias', value=dizi)
'''
X = data.iloc[:,:2].values
y = data.iloc[:,2].values



#X = data.iloc[:,:3].values
#y = data.iloc[:,3].values

#print("y  :",y)


#out_array = np.log(y + 1)

#print(out_array)

#print(max(out_array))
#print(min(out_array))
# create linear regression object
reg = linear_model.LinearRegression()

reg.fit(X, y)
y_new = reg.predict(X)


print('Intercept: \n', reg.intercept_)
print('Coefficients: \n', reg.coef_)

# variance score: 1 means perfect prediction
print('Variance score: {}'.format(reg.score(X, y)))

from sklearn.metrics import mean_squared_error
a = mean_squared_error(y, y_new)
print("mse :", a)


#bias = 1
#New_Interest_Rate = 149.3
#New_Unemployment_Rate = 728.6
#print('Predicted Stock Index Price: \n', reg.predict([[bias , New_Interest_Rate, New_Unemployment_Rate]]))

