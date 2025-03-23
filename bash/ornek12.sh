function kontrol() {
    if [ $1 -gt 10 ]
    then return 1
    else return 0
    fi
}

kontrol 15
echo "Dönen kod: $?"

