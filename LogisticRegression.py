import pandas as pd
import matplotlib.pyplot as plt
import numpy as np



#data = pd.read_csv('stringArrayYuksekDegersiz.csv')
data = pd.read_csv('pca3Sutunlu.csv')
#, usecols=['DC','DMC','AREA']
X = data.iloc[:,:2].values
y = data.iloc[:,2].values

'''
for i in range(len(y)):
    if y[i] > 0:
        y[i] = 1
'''

print("mean :",y.mean())

import statistics

print("median ,",statistics.median(y))
print(min(y))
count = 0
for i in range(len(y)):
    if y[i] >-18 and y[i] <-3 :
        count = count +1
        y[i] = 0
    else:
        y[i] = 1


print(count)


from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2,train_size=0.8 , random_state=0)


from sklearn.linear_model import LogisticRegression

# instantiate the model (using the default parameters)
logreg = LogisticRegression()

# fit the model with data
logreg.fit(X_train,y_train)

#
y_pred=logreg.predict(X_test)

print('Accuracy of K-NN classifier on training set: {:.2f}'
     .format(logreg.score(X_train, y_train)))
print('Accuracy of K-NN classifier on test set: {:.2f}'
     .format(logreg.score(X_test, y_test)))



from sklearn.metrics import accuracy_score

acc = accuracy_score(y_test, y_pred)

print("acc : ", acc)



from sklearn import metrics
cnf_matrix = metrics.confusion_matrix(y_test, y_pred)
print(cnf_matrix)



from sklearn.model_selection import cross_val_score
clf= LogisticRegression()
cv_scores = cross_val_score(clf, X, y)

print('Cross-validation scores (3-fold):', cv_scores)
print('Mean cross-validation score (3-fold): {:.3f}'
     .format(np.mean(cv_scores)))

from sklearn.metrics import roc_curve
from matplotlib import pyplot


#fpr, tpr, thresholds = roc_curve(y_test, y_pred)
#pyplot.plot([0, 1], [0, 1], linestyle='--')
# plot the roc curve for the model
#pyplot.plot(fpr, tpr, marker='.')
# show the plot
#pyplot.show()
'''
from sklearn.metrics import precision_recall_curve
precision, recall, thresholds = precision_recall_curve(y_test, y_pred)
pyplot.plot(recall, precision, marker='.')
# calculate F1 score
from sklearn.metrics import f1_score
f1 = f1_score(y_test, y_pred)
pyplot.show()
'''
'''

X
Y
MONTH
DAY
FFMC
DMC
DC
ISI
TEMP
RH
WIND
RAIN
AREA
'''


#print('Predicted Burned Area: \n', logreg.predict(np.array([5,6,10,2,90.9,126.5,686.5,7,14.7,70,3.6,0]).reshape(1, 12)))

from sklearn.metrics import classification_report
print(classification_report(y_test, y_pred))







