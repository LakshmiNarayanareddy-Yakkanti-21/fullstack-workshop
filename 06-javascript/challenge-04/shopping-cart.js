function createShoppingCart() {
  return {
    items: [],
    discount: 0,  

    addItem(item) {
      const existing = this.items.find(p => p.id === item.id);
      if (existing) {
        existing.quantity += item.quantity;
      } else {
        this.items.push({ ...item });
      }
    },

    updateQuantity(id, qty) {
      const product = this.items.find(item => item.id === id);
      if (product) product.quantity = qty;
    },

    removeItem(id) {
      this.items = this.items.filter(item => item.id !== id);
    },

    getItems() {
      return this.items;
    },

    getTotal() {
      let total = this.items.reduce(
        (sum, item) => sum + item.price * item.quantity,
        0
      );
      return +(total - (total * this.discount) / 100).toFixed(2);
    },

    getItemCount() {
      return this.items.reduce((sum, item) => sum + item.quantity, 0);
    },

    isEmpty() {
      return this.items.length === 0;
    },

    applyDiscount(code, percent) {
      if (code === "SAVE10") {
        this.discount = percent;
      }
    },

    clear() {
      this.items = [];
      this.discount = 0;
    }
  };
}