.section .data

.section .text

    .global move_num_vec

    # Arguments:
    # rdi -> int* array
    # rsi -> int length
    # rdx -> int* read
    # rcx -> int* write
    # r8  -> int num
    # r9  -> int* vec


#-------------------------BEGINING--------------------------------------


move_num_vec:

    pushq %rbx
    pushq %rbp
    movq %rsp, %rbp

    cmpq %r8, %rbx            # Compare with the requested number to move

		#IF R8 < RBX
		jl not_enough_elements    # Jump if not enough elements

    movq %r9, %r11           # Store the destination address in %r11

    movq $0, %rax            # use %rax as a counter start it at 0


#--------------------------START COPY-----------------------------------

copy:

     movslq (%rdx, %rax, 4), %r9   # Move the 32-bit value to the destination
     movq %r9, (%r11)

     addq $1, %rax                 # add 1 to the counter
     addq $4, %r11                 # adds 4 bits to the vec to pass to the next positon

     decq %r8                      # decrement num

		#IF NUM = 0
		jz enough_elements            # jumps to enough_elements


     jmp copy              # jump to the loop again


#-------------------ENOUGHT ELEMENTS IN ARRAY---------------------------


enough_elements:

    movq $1, %rax                 # Set return value to 1
    jmp final                      # Jump to done


#------------------NOT ENOUGH ELEMENTS IN ARRAY-------------------------


not_enough_elements:

    movq $0, %rax                 # Set return value to 0


#------------------------FINAL------------------------------------------

final:

    popq %rbp                     # Restore registers
    popq %rbx                     # Restore old value %rdx

    ret                           # Return value
