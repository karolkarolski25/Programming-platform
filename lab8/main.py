from sqlalchemy import create_engine

from db import User, Address, EMailAddress, PhoneNumber, create_metadata
# from EMailAddress import EMailAddress
# from PhoneNumber import PhoneNumber

engine = create_engine("sqlite:///users.db")

create_metadata(engine)


def add_users(n):
    for i in range(n):
        user = User.add(f"FirstName{i}", f"LastName{i}")
        Address.add_address(user, f"street{i}", f"town{i}", f"postalCode{i}")
        EMailAddress.add_emailAddress(user, f"mail{i}")
        PhoneNumber.add_phone(user, f"phone{i}1")
        PhoneNumber.add_phone(user, f"phone{i}2")

        print(str(i))

add_users(0)

user = User.add("FirstNameTest", "LastNameTest")
Address.add_address(user, "streetTest", "townTest", "postalCodeTest")
EMailAddress.add_emailAddress(user, "mailTest")
PhoneNumber.add_phone(user, "phoneTest1")
PhoneNumber.add_phone(user, "phoneTest2")

user1 = User.add("FirstNameQwerty", "LastNameQwerty")
Address.add_address(user1, "streetQwerty", "townQwerty", "postalCodeQwerty")
EMailAddress.add_emailAddress(user1, "mailQwerty")
PhoneNumber.add_phone(user1, "phoneQwerty1")
PhoneNumber.add_phone(user1, "phoneQwerty2")

user.connect_with_other(user1)

users = User.find(['FirstName25', 'FirstNameTest', 'FirstName10'])

print()

for i in range(len(users)):
    print(users[i])
    print()
