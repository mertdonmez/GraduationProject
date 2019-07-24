
import numpy as np
import pandas as pd
from sklearn.tree import DecisionTreeClassifier
from sklearn.metrics import accuracy_score
from sklearn import tree



data = pd.read_csv('stringArrayYuksekDegersiz.csv')
#, usecols=['DC','DMC','AREA']
X = data.iloc[:,:12].values
y = data.iloc[:,12].values

for i in range(len(y)):
    if y[i] > 0:
        y[i] = 1



from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2,train_size=0.8)



clf_gini = DecisionTreeClassifier(criterion = "gini", random_state = 100,
                               max_depth=3, min_samples_leaf=5)
clf_gini.fit(X_train, y_train)



clf_entropy = DecisionTreeClassifier(criterion = "entropy", random_state = 100,
 max_depth=3, min_samples_leaf=5)
clf_entropy.fit(X_train, y_train)





y_pred = clf_gini.predict(X_test)


y_pred_en = clf_entropy.predict(X_test)

print( "Accuracy is ", accuracy_score(y_test,y_pred)*100)

print( "Accuracy is  en", accuracy_score(y_test,y_pred_en)*100)




