private void loadFragment() {
        // FragmentTransaction példány létrehozása
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        // Fragment hozzáadása vagy cseréje
        MyFragment myFragment = new MyFragment();
        fragmentTransaction.replace(R.id.fragmentContainer, myFragment); // R.id.fragmentContainer a hely, ahol a fragment megjelenik

        // Visszavonás (back stack) hozzáadása, ha szükséges
        fragmentTransaction.addToBackStack(null);

        // FragmentTransaction végrehajtása
        fragmentTransaction.commit();
    }
}
