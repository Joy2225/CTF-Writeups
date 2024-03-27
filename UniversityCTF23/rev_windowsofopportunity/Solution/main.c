
undefined8 main(void)

{
  char arr={0x9c, 0x96, 0xbd, 0xaf, 0x93, 0xc3, 0x94, 0x60, 0xa2, 0xd1, 0xc2, 0xcf, 0x9c, 0xa3, 0xa6, 0x68, 0x94, 0xc1, 0xd7, 0xac, 0x96, 0x93, 0x93, 0xd6, 0xa8, 0x9f, 0xd2, 0x94, 0xa7, 0xd6, 0x8f, 0xa0, 0xa3, 0xa1, 0xa3, 0x56, 0x9e} // Obtained from the decompiled code in ghidra at the location of arr
  char local_38 [43];
  char local_d;
  uint local_c;
  
  puts("A voice comes from the window... \'Password?\'");
  fgets(local_38,0x2a,stdin);
  local_c = 0;
  while( true ) {
    if (36 < local_c) {
      puts("The window opens to allow you passage...");
      return 0;
    }
    local_d = local_38[(int)(local_c + 1)] + local_38[(int)local_c];
    if (local_d != arr[(int)local_c]) break;
    local_c = local_c + 1;
  }
  puts("The window slams shut...");
  return 0xffffffff;
}
