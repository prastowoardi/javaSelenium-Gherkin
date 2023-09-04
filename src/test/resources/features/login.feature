Feature: User login ke web Luma
  
  Background:
    Given Buka browser
    * Buka web Luma
    * Buka halaman "login"
    
  Scenario: Login dengan akun Andi Hazz
    When User memasukkan "emailLogin" dengan "hazz@mail.com"
    * User memasukkan "passLogin" dengan "a1cab2f5@"
    * User klik tombol "Sign In"
    * Cek apakah user sudah login

  Scenario: Login dengan akun akun Raki
    When User memasukkan "emailLogin" dengan "hazz@mail.com"
    * User memasukkan "passLogin" dengan "a1cab2f5@"
    * User klik tombol "Sign In"
    * Cek apakah user sudah login