Here's how the Factory pattern can help:

1. **Centralized Object Creation**: The Factory class handles the creation of `AccountDAO` instances. This removes the
   responsibility of choosing the correct DAO from the `AccountService` and `CustomerService` classes.

2. **Separation of Concerns**: By using a Factory, the `AccountService` and `CustomerService` classes no longer need to
   know which specific implementation of `AccountDAO` to use.

3. **Environment Switching**: The concrete Factory can decide which implementation to provide. This makes switching
   between production and test environments seamless without requiring changes in the service classes.
