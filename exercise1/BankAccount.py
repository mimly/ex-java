################################################
########## BANK ACCOUNT SPECIFICATION ##########
################################################
#==============================================#
# CLEARING NUMBER (4 digits) : str
# ACCOUNT NUMBER (6 random digits) : str
# PERSONAL NUMBER : str
# NAME : str
# BALANCE : float
# INTEREST RATE : float
#==============================================#
# GET_ACCOUNT_NUMBER ( ) -> str
# GET_ACCOUNT_OWNER ( ) -> str
# GET_BALANCE ( ) -> float
# CALCULATE_BALANCE_AFTER ( YEARS: int ) -> float
# DEPOSIT ( AMOUNT : float ) -> None
# WITHDRAW ( AMOUNT : float ) -> None
# GET_INTEREST_RATE ( ) -> float
# SET_INTEREST_RATE ( RATE: float ) -> None
#==============================================#

import random


def _validate(method):
    def inner(self, arg):
        if not isinstance(arg, (float, int)) or arg <= 0.0:
            raise ValueError("Only positive values allowed.")

        return method(self, arg)

    return inner


class BankAccount(object):

    """Docstring for BankAccount. """

    _CLEARING_NUMBER = "1234"
    _interest_rate = 8.0

    def __init__(self, personal_number, name, balance=0.0):
        self._ACCOUNT_NUMBER = str(random.randint(100000, 999999))
        self._PERSONAL_NUMBER = personal_number
        self._name = name
        self._balance = balance

    def __str__(self):
        return f"BankAccount{{ACCOUNT NUMBER = {self._CLEARING_NUMBER}-{self._ACCOUNT_NUMBER}, PERSONAL NUMBER = {self._PERSONAL_NUMBER}, NAME = {self._name}, BALANCE = {self._balance}, INTEREST RATE = {self._interest_rate}}}"

    @property
    def accountNumber(self):
        return f"{self._CLEARING_NUMBER}-{self._ACCOUNT_NUMBER}"

    @property
    def accountOwner(self):
        return f"{self._PERSONAL_NUMBER} {self._name}"

    @property
    def balance(self):
        return self._balance

    @_validate
    def calculate_balance_after(self, years):
        return self._balance * ((1 + (type(self)._interest_rate / 100)) ** years)

    @_validate
    def deposit(self, amount):
        self._balance += amount

    @_validate
    def withdraw(self, amount):
        if amount > self._balance:
            raise ValueError("Insufficient funds in the account.")
        self._balance -= amount

    @property
    def interest_rate(self):
        return type(self)._interest_rate

    @interest_rate.setter
    def interest_rate(self, rate):
        type(self)._interest_rate = rate
