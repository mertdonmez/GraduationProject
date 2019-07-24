import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

from matplotlib.colors import ListedColormap

#data = pd.read_csv('stringArrayYuksekDegersiz.csv')
data = pd.read_csv('pca3Sutunlu.csv')
#, usecols=['DC','DMC','AREA']
X = data.iloc[:,:2].values
y = data.iloc[:,2].values


print(min(y))
print(max(y))
'''

for i in range(len(y)):
    if y[i] >0:
        y[i] = 1

'''

count = 0
for i in range(len(y)):
    if y[i] >-18 and y[i] <-3 :
        count = count +1
        y[i] = 0
    else:
        y[i] = 1


print(count)
print(y)



from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.20,train_size=0.8 , random_state=0)




from sklearn.neighbors import KNeighborsClassifier
classifier = KNeighborsClassifier(n_neighbors=4 , weights='uniform' , metric='euclidean')
classifier.fit(X_train, y_train)

y_pred = classifier.predict(X_test)


from sklearn.metrics import accuracy_score

acc = accuracy_score(y_test, y_pred)

print("acc : ", acc)


print('Accuracy of K-NN classifier on training set: {:.2f}'
     .format(classifier.score(X_train, y_train)))
print('Accuracy of K-NN classifier on test set: {:.2f}'
     .format(classifier.score(X_test, y_test)))

from sklearn.metrics import classification_report, confusion_matrix
print(confusion_matrix(y_test, y_pred))
print(classification_report(y_test, y_pred))


error = []


from sklearn.model_selection import cross_val_score
clf= KNeighborsClassifier(n_neighbors = 1 , weights='uniform' , metric='euclidean')
cv_scores = cross_val_score(clf, X, y)

print('Cross-validation scores (3-fold):', cv_scores)
print('Mean cross-validation score (3-fold): {:.3f}'
     .format(np.mean(cv_scores)))


# Calculating error for K values between 1 and 40
for i in range(1, 40):
    knn = KNeighborsClassifier(n_neighbors=i)
    knn.fit(X_train, y_train)
    pred_i = knn.predict(X_test)
    error.append(np.mean(pred_i != y_test))


plt.figure(figsize=(12, 6))
plt.plot(range(1, 40), error, color='red', linestyle='dashed', marker='o',
         markerfacecolor='blue', markersize=10)
plt.title('Error Rate K Value')
plt.xlabel('K Value')
plt.ylabel('Mean Error')
plt.show()




