public class RotateRight{
      public void rotateRight() {
        
          endMarker.prev = endMarker.prev.prev;
          beginMarker.next.prev = endMarker.prev.next;
          endMarker.prev.next = endMarker;
          beginMarker.next.prev.next = beginMarker.next;
          beginMarker.next = beginMarker.next.prev;
          beignMarker.next.prev = beginMarker;
  }
}