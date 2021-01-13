import matplotlib.pyplot as plt
import pandas as pd
import seaborn as sns
from sklearn.datasets import load_boston
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error, mean_absolute_error


def loadData():
    boston_dataset = load_boston()
    print(boston_dataset.keys())
    o1 = pd.DataFrame(boston_dataset.data, columns=boston_dataset.feature_names)
    o1['MEDV'] = boston_dataset.target
    return o1


#1
boston=loadData()
print(f"First 10:\n{boston.head(10)}")
print(f"Last 10:\n{boston.tail(10)}")

#2
print("\nINFO")
boston.info(verbose=True)
#a 506
#b float64
#c no

#3
print("\nDESCRIBE")
print(boston.describe())

#a mean: 3.613524 | std: 8.601545
#b min: 5 | max: 50
#c med: 11.360000

#4
sns.distplot(boston['MEDV'])
plt.savefig("./histogram.png")
plt.show()

#5
sns.heatmap(boston.corr(), fmt='.2f', annot=True)
plt.savefig("./heatmap.png")
plt.show()

#A: RM, ZN, B, DIS
#B: LSTAT
#C: TAX - RAD

sns.regplot(x=boston['MEDV'], y=boston['RM'])
plt.show()
plt.savefig("./heatmapA.png")

sns.regplot(x=boston['MEDV'], y=boston['NOX'])
plt.show()
plt.savefig("./heatmapB.png")

sns.regplot(x=boston['MEDV'], y=boston['LSTAT'])
plt.show()
plt.savefig("./heatmapC.png")

#With strong correlation (point A)

#6
x, y = (boston[['RM', 'ZN', 'B']], boston['MEDV'])
x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.2)

print("x_test\n")
print(x_test)
print("\ny_test\n")
print(y_test)
print("\nx_train\n")
print(x_train)
print("\ny_train\n")
print(y_train)

#7
reg = LinearRegression().fit(x_train, y_train)

y_train_predicted = reg.predict(x_train)
y_test_predicted = reg.predict(x_test)

sns.scatterplot(x=y_train, y=y_train_predicted)
plt.show()
plt.savefig("./predTrain.png")

sns.scatterplot(x=y_test, y=y_test_predicted)
plt.show()
plt.savefig("./predTest.png")

#8
print(f"\nTrain (RMSE):{mean_squared_error(y_train, y_train_predicted)}")
print(f"Train (MAE) {mean_absolute_error(y_train, y_train_predicted)}")
print()
print(f"Test (RMSE): {mean_squared_error(y_test, y_test_predicted)}")
print(f"Test (MAE): {mean_absolute_error(y_test, y_test_predicted)}\n")
