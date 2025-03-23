echo "Hangi mevsimdesiniz? (kış/yaz)"
read mevsim

case $mevsim in
    kış) echo "Hava soğuk!" ;;
    yaz) echo "Hava sıcak!" ;;
    *) echo "Bilinmeyen bir mevsim girdiniz." ;;
esac

