import unittest
from greeter.greeter import Greeter


class TestGreeter(unittest.TestCase):

    def setUp(self):
        self.greeter = Greeter()

    def test_greet(self):
        result = self.greeter.greet("Alice")
        print(f"test_greet -> Expected: 'Hello, Alice!'  Got: '{result}'")
        self.assertEqual(result, "Hello, Alice!")

    # -------------------------------------------------------
    # Optional: Add your own tests below!
    # -------------------------------------------------------
    # Hint: Try writing a test for greet_loud() or greet_formal()
    # Example:
    #
    # def test_greet_formal(self):
    #     result = self.greeter.greet_formal("Alice")
    #     print(f"test_greet_formal -> Expected: 'Good day, Alice.'  Got: '{result}'")
    #     self.assertEqual(result, "Good day, Alice.")
    # -------------------------------------------------------


if __name__ == "__main__":
    unittest.main()
