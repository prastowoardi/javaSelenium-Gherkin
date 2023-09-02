Feature: User login ke web Luma
  
  Background:
    Given Buka browser
    * Buka web Luma
    * Buka halaman "login"
    
  Scenario: Login dengan akun yang sudah dibuat
    When User memasukkan "emailLogin" dengan "<email>"
    * User memasukkan "passLogin" dengan "<password>"
    * User klik tombol "Sign In"
    * Cek apakah user sudah login

    Examples:
      | email         | password  |
#      | raki@mail.con | okP0219!a |
      | hazz@mail.com | a1cab2f5@ |