p a c k a g e   p e r s o n a l . m i c k i e . e d u c a t i o n . c a l c . v i e w ; 
 
 i m p o r t   j a v a . a w t . B o r d e r L a y o u t ; 
 i m p o r t   j a v a . a w t . E v e n t Q u e u e ; 
 
 i m p o r t   j a v a x . s w i n g . J F r a m e ; 
 i m p o r t   j a v a x . s w i n g . J P a n e l ; 
 i m p o r t   j a v a x . s w i n g . b o r d e r . E m p t y B o r d e r ; 
 i m p o r t   j a v a x . s w i n g . J T e x t F i e l d ; 
 i m p o r t   j a v a . a w t . G r i d L a y o u t ; 
 i m p o r t   j a v a x . s w i n g . J B u t t o n ; 
 i m p o r t   j a v a . a w t . e v e n t . A c t i o n L i s t e n e r ; 
 i m p o r t   j a v a . a w t . e v e n t . A c t i o n E v e n t ; 
 i m p o r t   j a v a x . s w i n g . S w i n g C o n s t a n t s ; 
 i m p o r t   j a v a . a w t . F o n t ; 
 
 p u b l i c   c l a s s   C a l c M a i n W i n d o w   e x t e n d s   J F r a m e   i m p l e m e n t s   A c t i o n L i s t e n e r   { 
 
 	 / * * 
 	   *   
 	   * / 
 	 p r i v a t e   s t a t i c   f i n a l   l o n g   s e r i a l V e r s i o n U I D   =   - 3 7 7 0 1 6 4 8 8 9 6 2 3 5 6 7 5 0 3 L ; 
 	 p r i v a t e   J P a n e l   c o n t e n t P a n e ; 
 	 p r i v a t e   J T e x t F i e l d   d i g i t W i n d o w ; 
 	 p r i v a t e   J B u t t o n [ ]   c a l c B u t t o n s ; 
 	 p r i v a t e   s t a t i c   f i n a l   i n t   R O W   =   4 ; 
 	 p r i v a t e   s t a t i c   f i n a l   i n t   C O L   =   5 ; 
 	 p r i v a t e   s t a t i c   f i n a l   S t r i n g [ ]   b u t t o n T e x t s   =   { 
 	 	 	 " 7 " ,   " 8 " ,   " 9 " ,   " / " ,   " C E " , 
 	 	 	 " 4 " ,   " 5 " ,   " 6 " ,   " * " ,   " C " , 
 	 	 	 " 1 " ,   " 2 " ,   " 3 " ,   " - " ,   " �!" , 
 	 	 	 " + / - " ,   " 0 " ,   " . " ,   " + " ,   " = " , 
 	 	 	 } ; 
 
 	 / * * 
 	   *   L a u n c h   t h e   a p p l i c a t i o n . 
 	   * / 
 	 p u b l i c   s t a t i c   v o i d   m a i n ( S t r i n g [ ]   a r g s )   { 
 	 	 E v e n t Q u e u e . i n v o k e L a t e r ( n e w   R u n n a b l e ( )   { 
 	 	 	 p u b l i c   v o i d   r u n ( )   { 
 	 	 	 	 t r y   { 
 	 	 	 	 	 C a l c M a i n W i n d o w   f r a m e   =   n e w   C a l c M a i n W i n d o w ( ) ; 
 	 	 	 	 	 f r a m e . s e t V i s i b l e ( t r u e ) ; 
 	 	 	 	 }   c a t c h   ( E x c e p t i o n   e )   { 
 	 	 	 	 	 e . p r i n t S t a c k T r a c e ( ) ; 
 	 	 	 	 } 
 	 	 	 } 
 	 	 } ) ; 
 	 } 
 
 	 / * * 
 	   *   C r e a t e   t h e   f r a m e . 
 	   * / 
 	 p u b l i c   C a l c M a i n W i n d o w ( )   { 
 	 	 s e t D e f a u l t C l o s e O p e r a t i o n ( J F r a m e . E X I T _ O N _ C L O S E ) ; 
 	 	 s e t B o u n d s ( 1 0 0 ,   1 0 0 ,   4 5 0 ,   3 0 0 ) ; 
 	 	 c o n t e n t P a n e   =   n e w   J P a n e l ( ) ; 
 	 	 c o n t e n t P a n e . s e t B o r d e r ( n e w   E m p t y B o r d e r ( 5 ,   5 ,   5 ,   5 ) ) ; 
 	 	 c o n t e n t P a n e . s e t L a y o u t ( n e w   B o r d e r L a y o u t ( 0 ,   0 ) ) ; 
 	 	 s e t C o n t e n t P a n e ( c o n t e n t P a n e ) ; 
 	 	 
 	 	 / /   �0�0�0�0�0�0�0�0n0\Ob
 	 	 d i g i t W i n d o w   =   n e w   J T e x t F i e l d ( ) ; 
 	 	 d i g i t W i n d o w . s e t F o n t ( n e w   F o n t ( " M S   U I   G o t h i c " ,   F o n t . P L A I N ,   2 4 ) ) ; 
 	 	 d i g i t W i n d o w . s e t H o r i z o n t a l A l i g n m e n t ( S w i n g C o n s t a n t s . R I G H T ) ; 
 	 	 c o n t e n t P a n e . a d d ( d i g i t W i n d o w ,   B o r d e r L a y o u t . N O R T H ) ; 
 	 	 d i g i t W i n d o w . s e t C o l u m n s ( 1 0 ) ; 
 	 	 
 	 	 / /   �0�0�0�0�0�0�0�0�0Y0�0_0�0n0�0�0�0�0\Ob
 	 	 J P a n e l   p a n e l   =   n e w   J P a n e l ( ) ; 
 	 	 c o n t e n t P a n e . a d d ( p a n e l ,   B o r d e r L a y o u t . C E N T E R ) ; 
 	 	 p a n e l . s e t L a y o u t ( n e w   G r i d L a y o u t ( R O W ,   C O L ,   3 ,   3 ) ) ; 
 	 	 
 	 	 / /   T�0�0�0n0{v2�
 	 	 c a l c B u t t o n s   =   n e w   J B u t t o n [ R O W   *   C O L ] ; 
 	 	 
 	 	 f o r   ( i n t   r   =   0 ;   r   <   R O W ;   r + + )   { 
 	 	 	 f o r   ( i n t   c   =   0 ;   c   <   C O L ;   c   + + )   { 
 	 	 	 	 i n t   b u t t o n I n d e x   =   ( R O W   -   r   -   1 )   *   C O L   +   c ; 
 	 	 	 	 S t r i n g   b u t t o n L a b e l   =   b u t t o n T e x t s [ b u t t o n I n d e x ] ; 
 	 	 	 	 c a l c B u t t o n s [ b u t t o n I n d e x ]   =   n e w   J B u t t o n ( b u t t o n L a b e l ) ; 
 	 	 	 	 c a l c B u t t o n s [ b u t t o n I n d e x ] . s e t A c t i o n C o m m a n d ( b u t t o n L a b e l ) ; 
 	 	 	 	 / /   ; �0�0�0�0�0�0�0n0�[ň�e�lo0D0�0D0�0B0�0L00�N�Vo0ui�RXS}j0�e�lW0K0O�0j0D0�0F0k0W0f0D0�00
 	 	 	 	 c a l c B u t t o n s [ b u t t o n I n d e x ] . a d d A c t i o n L i s t e n e r ( t h i s ) ; 
 	 	 	 	 p a n e l . a d d ( c a l c B u t t o n s [ b u t t o n I n d e x ] ,   r ,   c ) ; 
 	 	 	 } 
 	 	 } 
 	 } 
 	 
 	 @ O v e r r i d e 
 	 / * * 
 	   *   �0�0�0n0�0�0�0L0�bU0�0_0h0M0n0�0�0�0�0
 	   * / 
 	 p u b l i c   v o i d   a c t i o n P e r f o r m e d ( A c t i o n E v e n t   e )   { 
 	 	 d i g i t W i n d o w . s e t T e x t ( e . g e t A c t i o n C o m m a n d ( ) ) ; 
 	 } 
 
 } 
 