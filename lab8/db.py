from sqlalchemy import Column, Integer, String, ForeignKey, Table
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import relationship, sessionmaker

Base = declarative_base()
Session = None

connection_table = Table('connection', Base.metadata,
                         Column('firstUserId', Integer, ForeignKey('users.id'), primary_key=True),
                         Column('secondUserId', Integer, ForeignKey('users.id'), primary_key=True)
                         )

class User(Base):
    __tablename__ = 'users'

    id = Column(Integer, primary_key=True)
    firstName = Column(String)
    lastName = Column(String)
    address = relationship('Address', back_populates='user')
    eMailAddresses = relationship("EMailAddress", back_populates='user')
    phoneNumber = relationship('PhoneNumber', back_populates='user')
    usersList = relationship('User', secondary=connection_table, back_populates='usersList',
                             primaryjoin=connection_table.c.firstUserId == id,
                             secondaryjoin=connection_table.c.secondUserId == id)

    def __repr__(self):
        return f"<User(firstName={self.firstName}, lastName={self.lastName}, address={self.address}, " \
               f"eMailAddresses={self.eMailAddresses}, phoneNumber={self.phoneNumber}, connected={self.usersList}>"

    @staticmethod
    def add(first_name, last_name):
        new_user = User(
            firstName=first_name,
            lastName=last_name
        )
        Session.add(new_user)

        Session.commit()

        return new_user

    @staticmethod
    def find(first_name):
        users_found = []

        session_query = Session.query(User)

        for i in range(len(first_name)):
            users_found.append(session_query.filter(User.firstName.like(first_name[i])).first())

        return users_found

    def connect(self, user):
        user.usersList.append(self)
        self.usersList.append(user)
        Session.commit()


class Address(Base):
    __tablename__ = 'addresses'

    id = Column(Integer, primary_key=True)
    userId = Column(Integer, ForeignKey('users.id'))
    user = relationship('User', back_populates='address')
    streetName = Column(String)
    town = Column(String)
    postalCode = Column(String)

    def __repr__(self):
        return f"<Address(streetName={self.streetName}, town={self.town}, postalCode={self.postalCode})>"

    @staticmethod
    def add_address(user, streetName, town, postalCode):
        Session.add(Address(
            user=user,
            streetName=streetName,
            town=town,
            postalCode=postalCode
        ))

        Session.commit()


class EMailAddress(Base):
    __tablename__ = 'emailAddresses'

    id = Column(Integer, primary_key=True)
    user_id = Column(Integer, ForeignKey('users.id'))
    user = relationship('User', back_populates='eMailAddresses')
    eMailAddress = Column(String)

    def __repr__(self):
        return f"<EMailAddress(eMailAddress={self.eMailAddress})>"

    @staticmethod
    def add_emailAddress(user, email):
        Session.add(EMailAddress(
            user=user,
            eMailAddress=email
        ))

        Session.commit()


class PhoneNumber(Base):
    __tablename__ = 'phoneNumbers'

    id = Column(Integer, primary_key=True)
    user_id = Column(Integer, ForeignKey('users.id'))
    user = relationship('User', back_populates="phoneNumber")
    phoneNumber = Column(String)

    def __repr__(self):
        return f"<PhoneNumber(phoneNumber={self.phoneNumber})>"

    @staticmethod
    def add_phone(user, phoneNumber):
        Session.add(PhoneNumber(
            user=user,
            phoneNumber=phoneNumber
        ))

        Session.commit()


def create_metadata(connection):
    global Session

    Base.metadata.create_all(connection)
    Session = sessionmaker(connection)()
