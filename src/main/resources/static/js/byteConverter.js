
function byteConverter( byte ){
    let count = 0;
    while (byte>999){
        byte = byte/1024;
        count++; 
    }
    byte = Math.round(byte * 100) / 100
    switch (count){
        case 0:
            return byte + " Bytes";
        case 1:
            return byte + " KB";
        case 2:
            return byte + " MB";
        case 3:
            return byte + " GB";
    }
}