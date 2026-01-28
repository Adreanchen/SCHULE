<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "Produkte".
 *
 * @property string $ProduktID
 * @property string $Produktname
 * @property string|null $Produktkategorie
 * @property float $Stueckpreis
 * @property int $LieferantenID
 *
 * @property Bestellungen[] $bestellnummers
 * @property Bestellpositionen[] $bestellpositionens
 * @property Lieferanten $lieferanten
 */
class Produkte extends \yii\db\ActiveRecord
{


    /**
     * {@inheritdoc}
     */
    public static function tableName()
    {
        return 'Produkte';
    }

    /**
     * {@inheritdoc}
     */
    public function rules()
    {
        return [
            [['Produktkategorie'], 'default', 'value' => null],
            [['ProduktID', 'Produktname', 'Stueckpreis', 'LieferantenID'], 'required'],
            [['Stueckpreis'], 'number'],
            [['LieferantenID'], 'integer'],
            [['ProduktID'], 'string', 'max' => 10],
            [['Produktname'], 'string', 'max' => 100],
            [['Produktkategorie'], 'string', 'max' => 50],
            [['ProduktID'], 'unique'],
            [['LieferantenID'], 'exist', 'skipOnError' => true, 'targetClass' => Lieferanten::class, 'targetAttribute' => ['LieferantenID' => 'LieferantenID']],
        ];
    }

    /**
     * {@inheritdoc}
     */
    public function attributeLabels()
    {
        return [
            'ProduktID' => Yii::t('app', 'Produkt ID'),
            'Produktname' => Yii::t('app', 'Produktname'),
            'Produktkategorie' => Yii::t('app', 'Produktkategorie'),
            'Stueckpreis' => Yii::t('app', 'Stueckpreis'),
            'LieferantenID' => Yii::t('app', 'Lieferanten ID'),
        ];
    }

    /**
     * Gets query for [[Bestellnummers]].
     *
     * @return \yii\db\ActiveQuery|BestellungenQuery
     */
    public function getBestellnummers()
    {
        return $this->hasMany(Bestellungen::class, ['Bestellnummer' => 'Bestellnummer'])->viaTable('Bestellpositionen', ['ProduktID' => 'ProduktID']);
    }

    /**
     * Gets query for [[Bestellpositionens]].
     *
     * @return \yii\db\ActiveQuery|BestellpositionenQuery
     */
    public function getBestellpositionens()
    {
        return $this->hasMany(Bestellpositionen::class, ['ProduktID' => 'ProduktID']);
    }

    /**
     * Gets query for [[Lieferanten]].
     *
     * @return \yii\db\ActiveQuery|LieferantenQuery
     */
    public function getLieferanten()
    {
        return $this->hasOne(Lieferanten::class, ['LieferantenID' => 'LieferantenID']);
    }

    /**
     * {@inheritdoc}
     * @return ProdukteQuery the active query used by this AR class.
     */
    public static function find()
    {
        return new ProdukteQuery(get_called_class());
    }

    public function iconUpdate()
    {
        return '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
  <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325"/>
</svg>';
    }

    public function iconDelete()
    {
        return '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
  <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5M11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47M8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5"/>
</svg>';
    }

    public function iconView()
    {
        return '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
  <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8M1.173 8a13 13 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5s3.879 1.168 5.168 2.457A13 13 0 0 1 14.828 8q-.086.13-.195.288c-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5s-3.879-1.168-5.168-2.457A13 13 0 0 1 1.172 8z"/>
  <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5M4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0"/>
</svg>';
    }
}
