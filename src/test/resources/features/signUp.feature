Feature: Sign Up di web Luma
  Scenario:  Sign up / register akun baru
    Given Buka browser
    * Buka web Luma
    * Buka halaman sign up
    * User memasukkan "first name" dengan "<first name>"
    * User memasukkan "last name" dengan "<last name>"
    * User memasukkan "email" dengan "<email>"
    * User memasukkan "password" dengan "<password>"
    * User memasukkan "confirm password" dengan "<confirm password>"
    * User klik tombol "create an account"
    Then Lihat alert

  Examples:
    | first name | last name | email         | password  | confirm password |
    | Reka       | Raki      | raki@mail.con | okP0219!a | okP0219!a        |
    | Andi       | Hazz      | hazz@mail.com | a1cab2f5@ | a1cab2f5@        |