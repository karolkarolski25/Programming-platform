import string
import collections
from functools import reduce
from pyLINQ import List


def zadanie_1(iterable):
    return List(iterable).select("x + 1")


def zadanie_2(ciag_liczb):
    return reduce(lambda a, b: a * b, ciag_liczb)


def zadanie_3(text):
    text = list(filter(lambda x: str.isalpha(x), str.lower(text)))
    return text == text[::-1]


def tokenize(text):  # zadanie_4
    return text.translate(str.maketrans('', '', string.punctuation)).lower().replace("  ", " ").strip().split(' ')


def read_from_file(path):
    with open(path, encoding='UTF-8') as input_file:
        text = input_file.read()

    return text


def remove_stop_words(text):  # zadanie_5
    return list(filter(lambda x: len(x) > 2 and x not in read_from_file('Pliki\pl.stopwords.txt'), tokenize(text)))


def count_most_frequent(text, n):  # zadanie_6
    text = text.replace(u'\xa0', u' ').replace('\n', ' ')
    return collections.Counter(remove_stop_words(text)).most_common(n)


def zadanie_7(text):
    dictionary = collections.defaultdict(list)

    for word in text:
        dictionary[''.join(sorted(word))].append(word)

    for key in sorted(dictionary, key=len, reverse=True):
        if len(dictionary[key]) > 1:
            return str(dictionary[key])


if __name__ == "__main__":
    print("Zadanie 1: " + str(zadanie_1([1, 2, 3, 4])))
    print("Zadanie 2: " + str(zadanie_2([1, 2, 3, 4])))
    print("Zadanie 3: " + str(zadanie_3("Tolo ma samolot")))
    print("Zadanie 4: " + str(tokenize("To be, or not to be - that is the question [...]")))
    print("Zadanie 5: " + str(remove_stop_words("aby witam byli pies")))
    print("Zadanie 6: " + str(count_most_frequent(read_from_file('Pliki\\trurl.txt'), 20)))
    print("Zadanie 7: " + str(zadanie_7(tokenize(read_from_file('Pliki\\unixdict.txt').replace('\n', ' ')))))
