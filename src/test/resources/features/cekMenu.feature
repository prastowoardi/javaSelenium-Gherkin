Feature: User melihat menu yang ada di web Luma

  Background:
    Given Buka browser
    * Buka web Luma
    * User login sebagai "Andi"

  Scenario: Melihat menu yang tersedia
    When User menuju halaman "Women Jackets"
    * Cek apakah halaman benar "Women Jacket"