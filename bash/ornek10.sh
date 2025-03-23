# dizi oluşturmak
meyveler=("Elma" "Armut" "Çilek" "Muz")

# elemanları çağırmak
echo "İlk eleman: ${meyveler[0]}"
echo "Tüm elemanlar: ${meyveler[@]}"
echo "Tüm elemanlar: ${meyveler[*]}"

# diziye eleman eklemek
meyveler+=("Karpuz") 
echo "Güncellenmiş dizi: ${meyveler[@]}"

# dizinin toplam eleman sayısını göstermek
echo "Dizideki toplam eleman sayısı: ${#meyveler[@]}"

# diziden eleman silmek
unset meyveler[1]
echo "Silindikten sonra: ${meyveler[@]}"

# döngü ile tüm elemanları gezmek
for meyve in ${meyveler[@]}
do echo "Meyve: $meyve"
done

