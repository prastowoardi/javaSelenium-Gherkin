Feature: User login ke web Luma
  
  Background:
    Given Buka browser
    * Buka web Luma
    * Buka halaman "login"
    
  Scenario: Login dengan akun yang sudah dibuat
    When User memasukkan "emailLogin" dengan "hazz@mail.com"
    * User memasukkan "passLogin" dengan "a1cab2f5@"
    * User klik tombol "Sign In"
    
    