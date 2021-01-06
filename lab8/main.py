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

# user = User.add("FirstNameTest", "LastNameTest")
# Address.add_address(user, "streetTest", "townTest", "postalCodeTest")
# EMailAddress.add_emailAddress(user, "mailTest")
# PhoneNumber.add_phone(user, "phoneTest1")
# PhoneNumber.add_phone(user, "phoneTest2")
#
# user1 = User.add("FirstNameQwerty", "LastNameQwerty")
# Address.add_address(user1, "streetQwerty", "townQwerty", "postalCodeQwerty")
# EMailAddress.add_emailAddress(user1, "mailQwerty")
# PhoneNumber.add_phone(user1, "phoneQwerty1")
# PhoneNumber.add_phone(user1, "phoneQwerty2")
#
#
# user.create_connection(user1)


users = User.find(['FirstName25', 'FirstNameTest', 'FirstNameQwerty'])

print()

for i in range(len(users)):
    if users[i] is not None:
        print(f"firstName: {users[i].firstName}")
        print(f"lastName: {users[i].lastName}")
        print(f"Address: {users[i].address}")
        print(f"eMailAddress: {users[i].eMailAddresses}")
        print(f"phoneNumbers {users[i].phoneNumber}")
        print(f"Connected users {users[i].usersList}")
    print()
